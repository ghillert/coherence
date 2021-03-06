/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */

package com.tangosol.io.pof.reflect;


import com.tangosol.io.ReadBuffer;

import com.tangosol.io.pof.PofContext;


/**
* PofCollection is {@link PofValue} implementation for collections.
*
* @author as  2009.03.06
* @since Coherence 3.5
*/
public class PofCollection
        extends PofArray
    {
    // ----- constructors ---------------------------------------------------

    /**
    * Construct a PofCollection instance wrapping the supplied buffer.
    *
    * @param valueParent parent value within the POF stream
    * @param bufValue    buffer containing POF representation of this value
    * @param ctx         POF context to use when reading or writing properties
    * @param of          offset of this value from the beginning of POF stream
    * @param nType       POF type identifier for this value
    * @param ofChildren  offset of the first child element within this value
    * @param cElements   the size of this collection
    */
    public PofCollection(PofValue valueParent, ReadBuffer bufValue, PofContext ctx,
            int of, int nType, int ofChildren, int cElements)
        {
        super(valueParent, bufValue, ctx, of, nType, ofChildren, cElements);
        }
    }