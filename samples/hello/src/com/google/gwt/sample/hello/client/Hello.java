/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.sample.hello.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import java.util.Objects;

/**
 * HelloWorld application.
 */
public class Hello implements EntryPoint {

  public void onModuleLoad() {
    Button b = new Button("Click me", new ClickHandler() {
      public void onClick(ClickEvent event) {
        sayHello(new Person("""
                Hello
                from
                AJAX
                """, "user"));

      sayHello(new Message("""
                Hello
                from
                AJAX
                """, "user"));
      }
    });

    RootPanel.get().add(b);
  }

  private void sayHello(Message message) {
    Window.alert(message.toString()+","+message.label()+","+message.name());
  }

  private void sayHello(Person person) {
    Window.alert(person.toString()+","+person.getName()+","+person.getTitle());
  }

  public static sealed class Shape permits Square, Circle {

  }

  public static final class Square extends Shape {

  }
  public static final class Circle extends Shape {

  }
//  public static final class Rectangle extends Shape {
//
//  }

  public record Message(String label, String name) {}

  public static final class Person {

    private final String name;
    private final String title;

    public Person(String name, String title){
      this.name = name;
      this.title = title;
    }

    public String getName() {
      return name;
    }

    public String getTitle() {
      return title;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "Person{" +
              "name='" + name + '\'' +
              ", title='" + title + '\'' +
              '}';
    }

    public boolean equals(Object object) {
      if (this == object) return true;
      if (object == null || getClass() != object.getClass()) return false;
      if (!super.equals(object)) return false;
      Person person = (Person) object;
      return Objects.equals(name, person.name) && Objects.equals(title, person.title);
    }

    public int hashCode() {
      return Objects.hash(name, title);
    }
  }
}
