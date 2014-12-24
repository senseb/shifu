package ml.shifu.shifu.udf;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.pig.EvalFunc;
import org.apache.pig.data.*;
import org.apache.pig.impl.logicalLayer.schema.Schema;

import java.io.IOException;

/**
 * Created on 12/5/2014.
 */
public class DuplicateTuple extends EvalFunc<DataBag> {

    private int multiplier = 3;

    public DuplicateTuple() {
        // default constructor
    }

    public DuplicateTuple(String multiplierStr) {
        this.multiplier = Integer.parseInt(multiplierStr);
    }

    @Override
    public DataBag exec(Tuple input) throws IOException {
        DataBag dataBag = BagFactory.getInstance().newDefaultBag();

        for ( int i = 0; i < this.multiplier; i ++ ) {
            dataBag.add(input);
        }

        return dataBag;
    }

}
