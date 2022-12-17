/**
 * Copyright (c) 2008, SnakeYAML
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.yaml.snakeyaml.constructor;

public class Wheel {

  private int id;

  public Wheel(int id) {
    this.id = id;
  }

  public Wheel() {
    this(0);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Wheel id=" + id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Wheel) {
      Wheel wheel = (Wheel) obj;
      return id == wheel.getId();
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Integer.valueOf(id).hashCode();
  }
}
