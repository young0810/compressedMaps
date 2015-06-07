/*
 * (C) Copyright 2015 Mikhail Vorontsov ( http://java-performance.info/ ) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *      Mikhail Vorontsov
 */

package info.javaperformance.serializers;

import info.javaperformance.tools.VarLen;

/**
 * Default serialization for using varlen encoding
 */
public final class DefaultLongSerializer implements ILongSerializer
{
    public static final ILongSerializer INSTANCE = new DefaultLongSerializer();

    private DefaultLongSerializer(){}

    @Override
    public void write(long v, ByteArray buf) {
        VarLen.writeSignedLong( v, buf );
    }

    @Override
    public long read(ByteArray buf) {
        return VarLen.readSignedLong( buf );
    }

    @Override
    public void writeDelta(long prevValue, long curValue, ByteArray buf, boolean sorted) {
        if ( sorted )
            VarLen.writeUnsignedLong( curValue - prevValue, buf );
        else
            VarLen.writeSignedLong( curValue - prevValue, buf );
    }

    @Override
    public long readDelta(long prevValue, ByteArray buf, boolean sorted) {
        if ( sorted )
            return prevValue + VarLen.readUnsignedLong(buf);
        else
            return prevValue + VarLen.readSignedLong( buf );
    }

    @Override
    public int getMaxLength() {
        return 10;
    }
}
