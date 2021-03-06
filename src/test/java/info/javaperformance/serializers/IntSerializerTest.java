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

import junit.framework.TestCase;

public class IntSerializerTest extends TestCase {
    public void testDelta()
    {
        final IIntSerializer s = DefaultIntSerializer.INSTANCE;
        final ByteArray bar = new ByteArray(  ).reset( new byte[ 1000 ] );
        //sorted first
        bar.position( 0 );
        s.write( Integer.MIN_VALUE, bar );
        s.writeDelta( Integer.MIN_VALUE, Integer.MAX_VALUE, bar, true );

        bar.position( 0 );
        assertEquals( Integer.MIN_VALUE, s.read( bar ) );
        assertEquals( Integer.MAX_VALUE, s.readDelta( Integer.MIN_VALUE, bar, true ) );
        //then not sorted
        bar.position( 0 );
        s.write( Integer.MIN_VALUE, bar );
        s.writeDelta( Integer.MIN_VALUE, Integer.MAX_VALUE, bar, false );

        bar.position( 0 );
        assertEquals( Integer.MIN_VALUE, s.read( bar ) );
        assertEquals( Integer.MAX_VALUE, s.readDelta( Integer.MIN_VALUE, bar, false ) );
    }
}
