/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */

package org.elasticsearch.xpack.runtimefields.query;

import org.apache.lucene.util.BytesRef;
import org.elasticsearch.script.Script;
import org.elasticsearch.xpack.runtimefields.IpScriptFieldScript;

public class IpScriptFieldExistsQuery extends AbstractIpScriptFieldQuery {
    public IpScriptFieldExistsQuery(Script script, IpScriptFieldScript.LeafFactory leafFactory, String fieldName) {
        super(script, leafFactory, fieldName);
    }

    @Override
    protected boolean matches(BytesRef[] values, int count) {
        return count > 0;
    }

    @Override
    public final String toString(String field) {
        if (fieldName().contentEquals(field)) {
            return getClass().getSimpleName();
        }
        return fieldName() + ":" + getClass().getSimpleName();
    }

    // Superclass's equals and hashCode are great for this class
}
