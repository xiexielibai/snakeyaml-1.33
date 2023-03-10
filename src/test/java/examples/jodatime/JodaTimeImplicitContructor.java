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
package examples.jodatime;

import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

/**
 * It works only when JodaTime is not a JavaBean property
 */
public class JodaTimeImplicitContructor extends Constructor {

  public JodaTimeImplicitContructor() {
    super(new LoaderOptions());
    this.yamlConstructors.put(Tag.TIMESTAMP, new ConstructJodaTimestamp());
  }

  private class ConstructJodaTimestamp extends ConstructYamlTimestamp {

    public Object construct(Node node) {
      Date date = (Date) super.construct(node);
      return new DateTime(date, DateTimeZone.UTC);
    }
  }
}
