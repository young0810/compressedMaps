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

package info.javaperformance.compressedmaps;

import info.javaperformance.compressedmaps.normal.doubles.*;
import info.javaperformance.compressedmaps.concurrent.doubles.*;

import info.javaperformance.serializers.IFloatSerializer;

import info.javaperformance.serializers.ILongSerializer;

import info.javaperformance.serializers.IDoubleSerializer;

import info.javaperformance.serializers.IIntSerializer;

/**
 * The entry point for all map users. This class provides the factory methods which allow you to create
 * the maps without binding yourself to the concrete implementations.
 *
 * All factories have the same constraints:
 * - fill factor between 0.01 (exclusive) and 16 (inclusive)
 * - initial size could be greater than {@code Integer.MAX_VALUE} (it makes sense because the fill factor could be greater than 1)
 */
public class DoubleMapFactory
{
    /////////////////////////////////////////////////////////////
    //  Single threaded maps
    /////////////////////////////////////////////////////////////

    public IDoubleIntMap singleThreadedDoubleIntMap( final long size, final float fillFactor )
    {
        return new DoubleIntChainedMap( size, fillFactor );
    }

    public IDoubleIntMap singleThreadedDoubleIntMap( final long size, final float fillFactor,
                                                   final IDoubleSerializer keySerializer, final IIntSerializer valueSerializer,
                                                   final long blockCacheLimit )
    {
        return new DoubleIntChainedMap( size, fillFactor, keySerializer, valueSerializer, blockCacheLimit );
    }

    public IDoubleLongMap singleThreadedDoubleLongMap( final long size, final float fillFactor )
    {
        return new DoubleLongChainedMap( size, fillFactor );
    }

    public IDoubleLongMap singleThreadedDoubleLongMap( final long size, final float fillFactor,
                                                   final IDoubleSerializer keySerializer, final ILongSerializer valueSerializer,
                                                   final long blockCacheLimit )
    {
        return new DoubleLongChainedMap( size, fillFactor, keySerializer, valueSerializer, blockCacheLimit );
    }

    public IDoubleFloatMap singleThreadedDoubleFloatMap( final long size, final float fillFactor )
    {
        return new DoubleFloatChainedMap( size, fillFactor );
    }

    public IDoubleFloatMap singleThreadedDoubleFloatMap( final long size, final float fillFactor,
                                                   final IDoubleSerializer keySerializer, final IFloatSerializer valueSerializer,
                                                   final long blockCacheLimit )
    {
        return new DoubleFloatChainedMap( size, fillFactor, keySerializer, valueSerializer, blockCacheLimit );
    }

    public IDoubleDoubleMap singleThreadedDoubleDoubleMap( final long size, final float fillFactor )
    {
        return new DoubleDoubleChainedMap( size, fillFactor );
    }

    public IDoubleDoubleMap singleThreadedDoubleDoubleMap( final long size, final float fillFactor,
                                                   final IDoubleSerializer keySerializer, final IDoubleSerializer valueSerializer,
                                                   final long blockCacheLimit )
    {
        return new DoubleDoubleChainedMap( size, fillFactor, keySerializer, valueSerializer, blockCacheLimit );
    }

    /////////////////////////////////////////////////////////////
    //  Concurrent maps
    /////////////////////////////////////////////////////////////

    public IDoubleIntConcurrentMap concurrentDoubleIntMap( final long size, final float fillFactor )
    {
        return new DoubleIntConcurrentChainedMap( size, fillFactor );
    }

    public IDoubleIntConcurrentMap concurrentDoubleIntMap( final long size, final float fillFactor,
                                                         final IDoubleSerializer keySerializer, final IIntSerializer valueSerializer )
    {
        return new DoubleIntConcurrentChainedMap( size, fillFactor, keySerializer, valueSerializer );
    }

    public IDoubleLongConcurrentMap concurrentDoubleLongMap( final long size, final float fillFactor )
    {
        return new DoubleLongConcurrentChainedMap( size, fillFactor );
    }

    public IDoubleLongConcurrentMap concurrentDoubleLongMap( final long size, final float fillFactor,
                                                         final IDoubleSerializer keySerializer, final ILongSerializer valueSerializer )
    {
        return new DoubleLongConcurrentChainedMap( size, fillFactor, keySerializer, valueSerializer );
    }

    public IDoubleFloatConcurrentMap concurrentDoubleFloatMap( final long size, final float fillFactor )
    {
        return new DoubleFloatConcurrentChainedMap( size, fillFactor );
    }

    public IDoubleFloatConcurrentMap concurrentDoubleFloatMap( final long size, final float fillFactor,
                                                         final IDoubleSerializer keySerializer, final IFloatSerializer valueSerializer )
    {
        return new DoubleFloatConcurrentChainedMap( size, fillFactor, keySerializer, valueSerializer );
    }

    public IDoubleDoubleConcurrentMap concurrentDoubleDoubleMap( final long size, final float fillFactor )
    {
        return new DoubleDoubleConcurrentChainedMap( size, fillFactor );
    }

    public IDoubleDoubleConcurrentMap concurrentDoubleDoubleMap( final long size, final float fillFactor,
                                                         final IDoubleSerializer keySerializer, final IDoubleSerializer valueSerializer )
    {
        return new DoubleDoubleConcurrentChainedMap( size, fillFactor, keySerializer, valueSerializer );
    }

}

