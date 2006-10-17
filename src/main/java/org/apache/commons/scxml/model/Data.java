/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;

import org.w3c.dom.Node;

/**
 * The class in this SCXML object model that corresponds to the SCXML
 * &lt;data&gt; child element of the &lt;datamodel&gt; element.
 *
 */
public class Data implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of this data instance, that is used as its identifier.
     */
    private String name;

    /**
     * The URL to get the XML data tree from.
     */
    private String src;

    /**
     * The expression that evaluates to the value of this data instance.
     */
    private String expr;

    /**
     * The child XML data tree, parsed as a Node, cloned per execution
     * instance.
     */
    private Node node;

    /**
     * Constructor.
     */
    public Data() {
        this.name = null;
        this.src = null;
        this.expr = null;
        this.node = null;
    }

    /**
     * Get the name.
     *
     * @return String The name.
     */
    public final String getName() {
        return name;
    }

    /**
     * Set the name.
     *
     * @param name The name.
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Get the URL where the XML data tree resides.
     *
     * @return String The URL.
     */
    public final String getSrc() {
        return src;
    }

    /**
     * Set the URL where the XML data tree resides.
     *
     * @param src The source URL.
     */
    public final void setSrc(final String src) {
        this.src = src;
    }

    /**
     * Get the expression that evaluates to the value of this data instance.
     *
     * @return String The expression.
     */
    public final String getExpr() {
        return expr;
    }

    /**
     * Set the expression that evaluates to the value of this data instance.
     *
     * @param expr The expression.
     */
    public final void setExpr(final String expr) {
        this.expr = expr;
    }

    /**
     * Get the XML data tree.
     *
     * @return Node The XML data tree, parsed as a <code>Node</code>.
     */
    public final Node getNode() {
        return node;
    }

    /**
     * Set the XML data tree.
     *
     * @param node The XML data tree, parsed as a <code>Node</code>.
     */
    public final void setNode(final Node node) {
        this.node = node;
    }

}

