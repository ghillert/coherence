/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates.
 *
 * Licensed under the Universal Permissive License v 1.0 as shown at
 * http://oss.oracle.com/licenses/upl.
 */
package com.tangosol.internal.util.invoke;

import com.tangosol.internal.util.invoke.Lambdas.SerializationMode;
import com.tangosol.internal.util.invoke.lambda.StaticLambdaInfo;
import com.tangosol.util.ValueExtractor;

import org.junit.BeforeClass;
import org.junit.Test;

import static com.tangosol.internal.util.invoke.Lambdas.LAMBDAS_SERIALIZATION_MODE_PROPERTY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author jf  2020.06.18
 */
@SuppressWarnings("unchecked")
public class StaticLambdasTest
    {
    @BeforeClass
    public static void setup()
        {
        // validate case-insensitive for configuring this property
        System.setProperty(LAMBDAS_SERIALIZATION_MODE_PROPERTY, SerializationMode.STATIC.name().toLowerCase());
        }

    @Test
    public void testConfiguredForStaticLambdas()
        {
        assertTrue(Lambdas.isStaticLambdas());
        }

    @Test
    public void testPofStaticLambda()
        {
        ValueExtractor<data.pof.Person, String> lambdaName = ValueExtractor.of(data.pof.Person::getName);
        Object o = Lambdas.ensureRemotable(lambdaName);
        assertEquals(o, lambdaName);

        o = Lambdas.ensureSerializable(lambdaName);
        assertTrue(o instanceof StaticLambdaInfo);
        }

    @Test
    public void testJavaStaticLambda()
        {
        ValueExtractor<data.Person, String> lambdaName = ValueExtractor.of(data.Person::getFirstName);
        Object o = Lambdas.ensureRemotable(lambdaName);
        assertEquals(lambdaName, o);

        o = Lambdas.ensureSerializable(lambdaName);
        assertTrue(o instanceof StaticLambdaInfo);
        }
    }
