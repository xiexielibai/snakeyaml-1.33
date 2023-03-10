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
package org.yaml.snakeyaml.immutable.primitives;

import java.util.Arrays;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Represent;
import org.yaml.snakeyaml.representer.Representer;

public class ImmutablePrimitivesRepresenter extends Representer {

  public ImmutablePrimitivesRepresenter() {
    super(new DumperOptions());
    this.representers.put(BunchOfPrimitives.class, new RepresentPrimitives());
  }

  class RepresentPrimitives implements Represent {

    public Node representData(Object data) {
      BunchOfPrimitives bunch = (BunchOfPrimitives) data;
      return representSequence(getTag(data.getClass(), new Tag(data.getClass())), Arrays
          .asList(bunch.getPrimitiveInt(), bunch.getPrimitiveDouble(), bunch.primitiveBoolean),
          DumperOptions.FlowStyle.FLOW);
    }
  }
}
