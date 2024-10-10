#!/bin/bash

set -e

move () {
   cp -r $1 $2
   git rm -rf $1
   git add $2
}
ORIGIN=
TARGET=
movejava () {
    cp $ORIGIN/$1 $TARGET/$1
    git rm -rf $ORIGIN/$1
    git add $TARGET/$1
}

# install external tools
pushd ideal/external
mvn install
popd


#  javaemul
# These utils and compiler hints are for internal use only, and are used in the lang project
mkdir -p ideal/javaemul/src/main/java/com/google/gwt/emul/javaemul/
move user/super/com/google/gwt/emul/javaemul/internal \
     ideal/javaemul/src/main/java/com/google/gwt/emul/javaemul/

pushd ideal/javaemul
mvn clean install
popd


#  core
# This consists of root GWT classes available to the user that are required to
# build and run the compiler (aside from JavaScriptObject)
mkdir -p ideal/core/src/main/java/com/google/gwt/core/client/{impl,prefetch} \
         ideal/core/src/main/java/com/google/gwt/core/shared/impl
move user/src/com/google/gwt/core/client/EntryPoint.java \
   ideal/core/src/main/java/com/google/gwt/core/client/EntryPoint.java # technically _not_ required!

# Direct dependencies from compiler
ORIGIN=user/src
TARGET=ideal/core/src/main/java
movejava com/google/gwt/core/client/GWT.java

movejava com/google/gwt/core/client/JavaScriptObject.java

movejava com/google/gwt/core/client/RunAsyncCallback.java

movejava com/google/gwt/core/client/impl/AsyncFragmentLoader.java

movejava com/google/gwt/core/client/impl/Impl.java

movejava com/google/gwt/core/client/prefetch/RunAsyncCode.java

# Transitive dependencies
movejava com/google/gwt/core/client/Scheduler.java

movejava com/google/gwt/core/shared/GWT.java

movejava com/google/gwt/core/client/impl/OnSuccessExecutor.java
movejava com/google/gwt/core/client/Duration.java
movejava com/google/gwt/core/client/JavaScriptException.java
movejava com/google/gwt/core/client/impl/JavaScriptExceptionBase.java
movejava com/google/gwt/core/client/impl/SuperDevModeLogger.java
#movejava com/google/gwt/core/client/impl/StackTraceCreator.java #Depends on lang's ArrayHelper, moved to lang
movejava com/google/gwt/core/client/impl/SchedulerImpl.java

movejava com/google/gwt/core/client/JsArray.java
movejava com/google/gwt/core/client/JsArrayString.java

movejava com/google/gwt/core/client/JsDate.java
movejava com/google/gwt/core/shared/impl/JsLogger.java

movejava com/google/gwt/core/client/prefetch/PrefetchableResource.java

movejava com/google/gwt/core/client/impl/ScriptTagLoadingStrategy.java

movejava com/google/gwt/core/client/impl/LoadingStrategyBase.java

movejava com/google/gwt/core/client/Callback.java

movejava com/google/gwt/core/client/ScriptInjector.java

movejava com/google/gwt/core/client/CodeDownloadException.java

git mv user/src/com/google/gwt/core/CompilerParameters.gwt.xml \
       user/src/com/google/gwt/core/CoreWithUserAgent.gwt.xml \
       user/src/com/google/gwt/core/StackTrace.gwt.xml \
       user/src/com/google/gwt/core/AsyncFragmentLoader.gwt.xml \
       user/src/com/google/gwt/core/CrossSiteIframeLinker.gwt.xml \
       user/src/com/google/gwt/core/XSLinker.gwt.xml \
       ideal/core/src/main/java/com/google/gwt/core/

# Hack to deal with legacy logging names
mkdir ideal/core/src/main/java/com/google/gwt/logging
git mv user/src/com/google/gwt/logging/LogImpl.gwt.xml ideal/core/src/main/java/com/google/gwt/logging/
git mv user/src/com/google/gwt/core/Core.gwt.xml ideal/core/src/main/module.gwt.xml


ORIGIN=dev/core/super
movejava com/google/gwt/core/shared/GWTBridge.java
movejava com/google/gwt/core/client/GWTBridge.java
movejava com/google/gwt/core/client/GwtScriptOnly.java


pushd ideal/core
mvn clean install
popd



#  lang
# Classes required to build and run the compiler, but not available to the user
# Normally these need not be compiled to bytecode, but ArrayHelper is used by core.
mkdir -p ideal/lang/src/main/java/com/google/gwt/dev/
mkdir -p ideal/lang/src/main/java/com/google/gwt/{core,lang}/
mkdir -p ideal/lang/src/main/java/com/google/gwt/core/client/impl/
# many of these types require core's JavaScriptObject

move dev/core/super/com/google/gwt/dev/jjs \
ideal/lang/src/main/java/com/google/gwt/dev/
move dev/core/super/com/google/gwt/lang \
ideal/lang/src/main/java/com/google/gwt/
move dev/core/super/com/google/gwt/core \
ideal/lang/src/main/java/com/google/gwt/

ORIGIN=user/src
TARGET=ideal/lang/src/main/java
movejava com/google/gwt/core/client/impl/StackTraceCreator.java #Depends on lang's ArrayHelper, and with broken loop, can live here


pushd ideal/lang
mvn clean install
popd

#  utils
# Classes required by most of the compiler, generators, linkers, command line tools...
mkdir -p ideal/util/src/main/java/com/google/gwt/dev/util/log/speedtracer \
         ideal/util/src/main/java/com/google/gwt/util/tools/ \
         ideal/util/src/main/java/com/google/gwt/core/ext
ORIGIN=dev/core/src
TARGET=ideal/util/src/main/java

move dev/core/src/com/google/gwt/dev/util/collect \
     ideal/util/src/main/java/com/google/gwt/dev/util/

movejava com/google/gwt/dev/util/Util.java #depends on TreeLogger, UnableToCompleteException,
# speedtracer...

movejava com/google/gwt/dev/util/StringInterningObjectInputStream.java
movejava com/google/gwt/util/tools/Utility.java
move dev/core/src/com/google/gwt/util/tools/shared ideal/util/src/main/java/com/google/gwt/util/tools/

#movejava com/google/gwt/core/ext/TreeLogger.java
movejava com/google/gwt/core/ext/UnableToCompleteException.java
#movejava com/google/gwt/dev/util/log/speedtracer/SpeedTracerEventType.java
#movejava com/google/gwt/dev/util/log/speedtracer/CompilerEventType.java
#movejava com/google/gwt/dev/util/log/speedtracer/SpeedTracerLogger.java
movejava com/google/gwt/dev/util/StringInterner.java #depends on rebased guava19
movejava com/google/gwt/dev/util/DefaultTextOutput.java
movejava com/google/gwt/dev/util/AbstractTextOutput.java
movejava com/google/gwt/dev/util/TextOutput.java


# HAAAAACK. Not really sure where this ought to belong, but ugly here.
# Also, need to replace strings in the Abouts
movejava com/google/gwt/dev/About.java
movejava com/google/gwt/dev/About.properties
movejava com/google/gwt/dev/GwtVersion.java

mkdir -p ideal/util/src/test/java/com/google/gwt/dev/util/collect
mkdir -p ideal/util/src/test/java/com/google/gwt/utils/tools/shared
ORIGIN=dev/core/test
TARGET=ideal/util/src/test/java
movejava com/google/gwt/dev/util/collect/*
movejava com/google/gwt/dev/util/UtilityTest.java
movejava com/google/gwt/utils/tools/shared/JavaScriptStringTest.java
movejava com/google/gwt/dev/AboutTest.java
movejava com/google/gwt/dev/GwtVersionTest.java

pushd ideal/util
mvn clean install
popd

#  linker/generator api
# GWT 1.x/2.x API to generate code and affect final compiled output
mkdir -p ideal/ext/src/main/java/com/google/gwt/core/ext/typeinfo \
         ideal/ext/src/main/java/com/google/gwt/core/ext/linker/impl \
         ideal/ext/src/main/java/com/google/gwt/dev/{resource,util,generator}/

ORIGIN=dev/core/src
TARGET=ideal/ext/src/main/java

movejava com/google/gwt/core/ext/Generator.java
movejava com/google/gwt/core/ext/IncrementalGenerator.java
movejava com/google/gwt/core/ext/GeneratorContext.java
movejava com/google/gwt/core/ext/TreeLogger.java
#movejava com/google/gwt/core/ext/UnableToCompleteException.java    #living in util for now
movejava com/google/gwt/core/ext/RebindResult.java
movejava com/google/gwt/core/ext/NonIncrementalGeneratorContext.java
movejava com/google/gwt/core/ext/DelegatingGeneratorContext.java
movejava com/google/gwt/core/ext/CachedGeneratorResult.java
movejava com/google/gwt/core/ext/RebindMode.java
movejava com/google/gwt/core/ext/PropertyOracle.java
movejava com/google/gwt/core/ext/ConfigurationProperty.java
movejava com/google/gwt/core/ext/SelectionProperty.java
movejava com/google/gwt/core/ext/BadPropertyValueException.java

move dev/core/src/com/google/gwt/core/ext/typeinfo \
     ideal/ext/src/main/java/com/google/gwt/core/ext/

movejava com/google/gwt/core/ext/Linker.java
movejava com/google/gwt/core/ext/LinkerContext.java
movejava com/google/gwt/core/ext/linker/Shardable.java
movejava com/google/gwt/core/ext/linker/Artifact.java
movejava com/google/gwt/core/ext/linker/EmittedArtifact.java
movejava com/google/gwt/core/ext/linker/GeneratedResource.java
movejava com/google/gwt/core/ext/linker/ArtifactSet.java
movejava com/google/gwt/core/ext/linker/TypeIndexedSet.java #depends on rebased guava19
movejava com/google/gwt/core/ext/linker/SelectionProperty.java
movejava com/google/gwt/core/ext/linker/ConfigurationProperty.java
movejava com/google/gwt/core/ext/linker/Transferable.java

movejava com/google/gwt/core/ext/linker/ScriptReference.java
movejava com/google/gwt/core/ext/linker/impl/ResourceInjectionUtil.java

movejava com/google/gwt/core/ext/linker/SoftPermutation.java
movejava com/google/gwt/core/ext/linker/StatementRanges.java
movejava com/google/gwt/core/ext/linker/SymbolData.java
movejava com/google/gwt/core/ext/linker/StylesheetReference.java
movejava com/google/gwt/core/ext/linker/AbstractLinker.java
movejava com/google/gwt/core/ext/linker/SyntheticArtifact.java

movejava com/google/gwt/dev/generator/NameFactory.java

movejava com/google/gwt/dev/resource/ResourceOracle.java
movejava com/google/gwt/dev/resource/Resource.java

movejava com/google/gwt/dev/util/DiskCache.java
movejava com/google/gwt/dev/util/StringKey.java
movejava com/google/gwt/dev/util/Pair.java

# okay, lets just move everything in these packages and not worry about exposing classes
# downstream shouldn't see
#move dev/core/src/com/google/gwt/core/ext/linker \
#     ideal/ext/src/main/java/com/google/gwt/core/ext/

# no? just copy what seems to be a published API
movejava com/google/gwt/core/ext/linker/CompilationResult.java
movejava com/google/gwt/core/ext/linker/LinkerOrder.java

ORIGIN=dev/core/test
TARGET=ideal/ext/src/test/java
movejava com/google/gwt/core/ext/linker/ArtifactSetTest.java
movejava com/google/gwt/core/ext/linker/TypeIndexedSetTest.java


pushd ideal/ext
mvn clean install
popd


#  built-in linkers for output that don't depend on the compiler (i.e. no soyc?)

# Move java
mkdir -p ideal/linkers/src/main/java/com/google/gwt/core/ext/linker/impl

ORIGIN=dev/core/src
TARGET=ideal/linkers/src/main/java

move dev/core/src/com/google/gwt/core/linker \
     ideal/linkers/src/main/java/com/google/gwt/core/

movejava com/google/gwt/core/ext/linker/impl/PropertiesMappingArtifact.java #used by xsiframe only?
movejava com/google/gwt/core/ext/linker/impl/SelectionScriptLinker.java
movejava com/google/gwt/core/ext/linker/impl/SelectionInformation.java
movejava com/google/gwt/core/ext/linker/impl/PropertiesUtil.java
movejava com/google/gwt/core/ext/linker/impl/PermutationsUtil.java

# deliberately not included, soyc lives in compiler for now?
#movejava com/google/gwt/core/ext/linker/impl/ModuleMetricsArtifact.java
# restore soyc for now
TARGET=dev/core/src
ORIGIN=ideal/linkers/src/main/java
mkdir -p dev/core/src/com/google/gwt/core/linker/
movejava com/google/gwt/core/linker/SoycReportLinker.java

# TODO linkers tests?
mkdir -p ideal/linkers/src/test/java
TARGET=dev/core/tests
ORIGIN=ideal/linkers/src/test/java

pushd ideal/linkers
mvn clean install
popd


#  emul
# Java Language emulation, basics required to compile at all
# JRE emulation, support for applications that depend on greater aspects of Java

mkdir -p ideal/emul/base/src/main/java/com/google/gwt/emul/java/{io,lang,util}

ORIGIN=user/super/com/google/gwt/emul
TARGET=ideal/emul/base/src/main/java/com/google/gwt/emul

movejava java/io/Serializable.java
movejava java/lang/Object.java
movejava java/lang/String.java
movejava java/lang/Class.java
movejava java/lang/CharSequence.java
movejava java/lang/Cloneable.java
movejava java/lang/Comparable.java
movejava java/lang/Enum.java
movejava java/lang/Iterable.java
movejava java/util/Iterator.java
movejava java/lang/AssertionError.java
movejava java/lang/Boolean.java
movejava java/lang/Byte.java
movejava java/lang/Character.java
movejava java/lang/Short.java
movejava java/lang/Integer.java
movejava java/lang/Long.java
movejava java/lang/Float.java
movejava java/lang/Double.java
movejava java/lang/Throwable.java

git mv user/super/com/google/gwt/emul/Preconditions.gwt.xml ideal/emul/base/src/main/java/com/google/gwt/emul/
git mv user/super/com/google/gwt/emul/Emulation.gwt.xml ideal/emul/base/src/main/module.gwt.xml

pushd ideal/emul/base
mvn clean install
popd

mkdir -p ideal/emul/jre/src/main/java/com/google/gwt/emul

move user/super/com/google/gwt/emul/java ideal/emul/jre/src/main/java/com/google/gwt/emul/

pushd ideal/emul/jre
mvn clean install
popd

pushd ideal/emul
mvn clean install
popd

#  codeserver
mkdir -p ideal/dev/codeserver/src/{main,test}/java/com/google/gwt/dev/codeserver
ORIGIN=dev/codeserver/src
TARGET=ideal/dev/codeserver/src/main/java
movejava com/google/gwt/dev/codeserver/*

ORIGIN=dev/codeserver/javatests
TARGET=ideal/dev/codeserver/src/test/java
movejava com/google/gwt/dev/codeserver/*


# dev mode
# We build this before the compiler (which it depends on) to remove classes from the compiler to
# just bulk copy the rest
mkdir -p ideal/dev/devmode/src/main/java/com/google/gwt/dev/{shell,ui}
ORIGIN=dev/core/src
TARGET=ideal/dev/devmode/src/main/java

movejava com/google/gwt/dev/DevelModeTabKey.java
movejava com/google/gwt/dev/DevMode.java
movejava com/google/gwt/dev/DevModeBase.java
movejava com/google/gwt/dev/Disconnectable.java
movejava com/google/gwt/dev/HeadlessUI.java
movejava com/google/gwt/dev/HostedMode.java
movejava com/google/gwt/dev/GWTMain.java
movejava com/google/gwt/dev/ModuleHandle.java
movejava com/google/gwt/dev/ModulePanel.java
movejava com/google/gwt/dev/ModuleTabPanel.java
movejava com/google/gwt/dev/RunWebApp.java
movejava com/google/gwt/dev/SessionModule.java
movejava com/google/gwt/dev/ServletValidator.java
movejava com/google/gwt/dev/SwingUI.java
movejava com/google/gwt/dev/WebServerPanel.java
movejava com/google/gwt/dev/ui/DevModeUI.java

move dev/core/src/com/google/gwt/dev/ui ideal/dev/devmode/src/main/java/com/google/gwt/dev
move dev/core/src/com/google/gwt/dev/shell/remoteui \
     ideal/dev/devmode/src/main/java/com/google/gwt/dev/shell/
move dev/core/src/com/google/gwt/dev/shell/rewrite \
     ideal/dev/devmode/src/main/java/com/google/gwt/dev/shell/
move dev/core/src/com/google/gwt/dev/shell/jetty \
     ideal/dev/devmode/src/main/java/com/google/gwt/dev/shell/
move dev/core/src/com/google/gwt/dev/shell/log \
     ideal/dev/devmode/src/main/java/com/google/gwt/dev/shell/

# CheckForUpdates, ie is an exception, it is used by the compiler, walk it manually
#movejava com/google/gwt/dev/shell/*
movejava com/google/gwt/dev/shell/BrowserChannel.java
movejava com/google/gwt/dev/shell/BrowserChannelClient.java
movejava com/google/gwt/dev/shell/BrowserChannelException.java
movejava com/google/gwt/dev/shell/BrowserChannelServer.java
movejava com/google/gwt/dev/shell/BrowserListener.java
movejava com/google/gwt/dev/shell/BrowserWidgetHost.java
movejava com/google/gwt/dev/shell/CloseButton.java
movejava com/google/gwt/dev/shell/CodeServerListener.java
movejava com/google/gwt/dev/shell/CompilingClassLoader.java
movejava com/google/gwt/dev/shell/DispatchClassInfo.java
movejava com/google/gwt/dev/shell/DispatchIdOracle.java
movejava com/google/gwt/dev/shell/EmmaStrategy.java
movejava com/google/gwt/dev/shell/GWTBridgeImpl.java
movejava com/google/gwt/dev/shell/JavaDispatchImpl.java
movejava com/google/gwt/dev/shell/JavaScriptHost.java
movejava com/google/gwt/dev/shell/Jsni.java
movejava com/google/gwt/dev/shell/JsValue.java
movejava com/google/gwt/dev/shell/JsValueGlue.java
movejava com/google/gwt/dev/shell/JsValueOOPHM.java
movejava com/google/gwt/dev/shell/MethodDispatch.java
movejava com/google/gwt/dev/shell/ModuleSpace.java
movejava com/google/gwt/dev/shell/ModuleSpaceHost.java
movejava com/google/gwt/dev/shell/ModuleSpaceOOPHM.java
movejava com/google/gwt/dev/shell/ModuleSpacePropertyOracle.java
movejava com/google/gwt/dev/shell/OophmSessionHandler.java
movejava com/google/gwt/dev/shell/RemoteObjectTable.java
movejava com/google/gwt/dev/shell/ServerMethods.java
movejava com/google/gwt/dev/shell/ServerObjectsTable.java
movejava com/google/gwt/dev/shell/ShellJavaScriptHost.java
movejava com/google/gwt/dev/shell/ShellMainWindow.java
movejava com/google/gwt/dev/shell/ShellModuleSpaceHost.java
movejava com/google/gwt/dev/shell/StaticResourceServer.java
movejava com/google/gwt/dev/shell/SuperDevListener.java
movejava com/google/gwt/dev/shell/SyntheticClassMember.java
movejava com/google/gwt/dev/shell/WrapLayout.java

# images
move dev/core/src/com/google/gwt/dev/shell/*.png \
     ideal/dev/devmode/src/main/java/com/google/gwt/dev/shell/
move dev/core/src/com/google/gwt/dev/shell/*.gif \
     ideal/dev/devmode/src/main/java/com/google/gwt/dev/shell/

#TODO can we move this down to junit3?
# Junit classes for devmode-htmlunit interaction
TARGET=ideal/dev/junit3/src/main/java
mkdir -p ideal/dev/junit3/src/main/java/com/google/gwt/dev/shell/
movejava com/google/gwt/dev/shell/HostedModePluginObject.java
movejava com/google/gwt/dev/shell/HtmlUnitSessionHandler.java
movejava com/google/gwt/dev/shell/JavaObject.java
movejava com/google/gwt/dev/shell/SessionData.java

ORIGIN=dev/core/test
TARGET=ideal/dev/devmode/src/test/java
movejava com/google/gwt/dev/shell
movejava com/google/gwt/dev/shell/remoteui


#  compiler
# Java to JavaScript Compiler
# Dependencies, which must be present in core, lang:
#  * com.google.gwt.dev.jjs.ast.JProgram#buildInitialTypeNamesToIndex (includes CODEGEN_TYPES_SET)
#  * com.google.gwt.dev.jjs.ast.JProgram#IMMORTAL_CODEGEN_TYPES_SET

mkdir -p ideal/dev/compiler/src/main/resources/com/google/gwt/dev/js
move dev/core/src/com/google/gwt/dev/js/globals ideal/dev/compiler/src/main/resources/com/google/gwt/dev/js/

mkdir -p ideal/dev/compiler/src/main/java/com/google/gwt/
move dev/core/src/com/google/gwt/core ideal/dev/compiler/src/main/java/com/google/gwt/
move dev/core/src/com/google/gwt/dev ideal/dev/compiler/src/main/java/com/google/gwt/
move dev/core/src/com/google/gwt/soyc ideal/dev/compiler/src/main/java/com/google/gwt/
move dev/core/src/com/google/gwt/util ideal/dev/compiler/src/main/java/com/google/gwt/


#  test tools (junit)
# TODO split this again, so that the API is in one jar, and the running magic in another?
# TODO this also depends on a lot of user stuff: safehtml, rpc, etc
mkdir -p ideal/dev/junit3/src/main/java/com/google/gwt
move user/src/com/google/gwt/junit ideal/dev/junit3/src/main/java/com/google/gwt/

pushd ideal/dev
mvn clean install
popd

#  tools
mkdir -p ideal/tools/api-checker/src/main/java/
move tools/api-checker/src/com ideal/tools/api-checker/src/main/java/

mkdir -p ideal/tools/cldr-import/src/main/java/
mkdir -p ideal/tools/cldr-import/src/test/java/
move tools/cldr-import/src/com ideal/tools/cldr-import/src/main/java/
move tools/cldr-import/test/com ideal/tools/cldr-import/src/test/java/

mkdir -p ideal/tools/datetimefmtcreator/src/main/java/
move tools/datetimefmtcreator/src/com ideal/tools/datetimefmtcreator/src/main/java/

pushd ideal/tools
mvn clean install
popd


# i18n-creator - TODO no pom yet, just a place to get these out of user
#
mkdir -p ideal/i18n-creator/src/main/java/com/google/gwt/i18n
move user/src/com/google/gwt/i18n/tools ideal/i18n-creator/src/main/java/com/google/gwt/i18n/

# webapp-creator - TODO no pom yet, just a place to get these out of user
# TODO also, there are some classes that compiler owns that we don't have, and we have to share with the i18n-creator
#
mkdir -p ideal/i18n-creator/src/main/java/com/google/gwt/user/
move user/src/com/google/gwt/user/tools ideal/i18n-creator/src/main/java/com/google/gwt/user/

# requestfactory client
# requestfactory shared
# requestfactory server
# requestfactory apt

mkdir -p ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/
move user/src/com/google/web/bindery/requestfactory/gwt ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/
move user/src/com/google/web/bindery/requestfactory/RequestFactory.gwt.xml ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/

mkdir -p ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/
move user/src/com/google/web/bindery/requestfactory/shared ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/
mkdir -p ideal/requestfactory/src/main/super/com/google/web/bindery/requestfactory/
move user/super/com/google/web/bindery/requestfactory/super/com/google/web/bindery/requestfactory/shared ideal/requestfactory/src/main/super/com/google/web/bindery/requestfactory/

mkdir -p ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/
move user/src/com/google/web/bindery/requestfactory/apt ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/

mkdir -p ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/
move user/src/com/google/web/bindery/requestfactory/server ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/
move user/src/com/google/web/bindery/requestfactory/vm ideal/requestfactory/src/main/java/com/google/web/bindery/requestfactory/

#  user
#
mkdir -p ideal/user/src/main/java/
move user/src/com ideal/user/src/main/java/
move user/src/javax ideal/user/src/main/java/
move user/src/org ideal/user/src/main/java/
mkdir -p ideal/user/src/main/super/
move user/super ideal/user/src/main/

pushd ideal/user
mvn clean install
popd

#  requestfactory



#  integration tests


#  samples
git rm samples/dynatable/build.xml
mkdir -p ideal/samples/dynatable/src/main/java
move samples/dynatable/src/com ideal/samples/dynatable/src/main/java/
mkdir -p ideal/samples/dynatable/src/main/webapp
# inlined "move" to avoid renaming afterwards
cp -r samples/dynatable/war/* ideal/samples/dynatable/src/main/webapp
git rm -rf samples/dynatable/war/
git add ideal/samples/dynatable/src/main/webapp

# dynatablerf is unfinished as requestfactory is unfinished
move samples/dynatablerf/src ideal/samples/dynatablerf/
#git rm samples/dynatablerf/build.xml
#git rm samples/dynatablerf/pom.xml
#git rm samples/dynatablerf/README-MAVEN.txt
#mkdir -p ideal/samples/dynatablerf/src/main/java
#move samples/dynatablerf/src ideal/samples/dynatablerf/

git rm samples/hello/build.xml
mkdir -p ideal/samples/hello/src/main/java
move samples/hello/src/com ideal/samples/hello/src/main/java/
mkdir -p ideal/samples/hello/src/main/webapp
# inlined "move" to avoid renaming afterwards
cp -r samples/hello/war/* ideal/samples/hello/src/main/webapp
git rm -rf samples/hello/war/
git add ideal/samples/hello/src/main/webapp

git rm samples/json/build.xml
mkdir -p ideal/samples/json/src/main/java
move samples/json/src/com ideal/samples/json/src/main/java/
mkdir -p ideal/samples/json/src/main/webapp
# inlined "move" to avoid renaming afterwards
cp -r samples/json/war/* ideal/samples/json/src/main/webapp
git rm -rf samples/json/war/
git add ideal/samples/json/src/main/webapp

git rm samples/mail/build.xml
mkdir -p ideal/samples/mail/src/main/java
move samples/mail/src/com ideal/samples/mail/src/main/java/
mkdir -p ideal/samples/mail/src/main/webapp
# inlined "move" to avoid renaming afterwards
cp -r samples/mail/war/* ideal/samples/mail/src/main/webapp
git rm -rf samples/mail/war/
git add ideal/samples/mail/src/main/webapp

# TODO mobilewebapp

git rm samples/showcase/build.xml
mkdir -p ideal/samples/showcase/src/main/java
move samples/showcase/src/com ideal/samples/showcase/src/main/java/
mkdir -p ideal/samples/showcase/src/main/webapp
# inlined "move" to avoid renaming afterwards
cp -r samples/showcase/war/* ideal/samples/showcase/src/main/webapp
git rm -rf samples/showcase/war/
git add ideal/samples/showcase/src/main/webapp

# TODO validation


#  uberjars for non-maven use

# Clean up old layout
git rm build.xml common.ant.xml platforms.ant.xml


# last, build the whole thing to make sure it is sane
pushd ideal
mvn clean install
popd

#git ci -m '...'