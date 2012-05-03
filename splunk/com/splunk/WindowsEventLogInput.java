/*
 * Copyright 2012 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.splunk;

/**
 * The {@code WindowsEventLogInput} class represents a Windows Event Log input.
 */
public class WindowsEventLogInput extends Input {

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     * @param path The Windows Event Log input endpoint.
     */
    WindowsEventLogInput(Service service, String path) {
        super(service, path);
    }

    /**
     * Returns a list of additional hosts used in monitoring.
     *
     * @return A comma-separated list of additional hosts used in monitoring, or {@code null} if not specified.
     */
    public String getHosts() {
        return getString("hosts", null);
    }

    /**
     * Returns the index name of this Windows Event Log input.
     *
     * @return The index name, or {@code null} if not specified.
     */
    public String getIndex() {
        return getString("index", null);
    }

    /**
     * Returns the input type of this Windows Event Log input.
     * @see InputKind
     *
     * @return The input kind.
     */
    public InputKind getKind() {
        return InputKind.WindowsEventLog;
    }

    /**
     * Returns the list of event log names to gather data from for this Windows
     * Event Log input.
     *
     * @return The list of event log names, or {@code null} if not specified.
     */
    public String [] getLogs() {
        return getStringArray("logs", null);
    }

    /**
     * Returns the collection name of this Windows Event Log input. This name
     * appears in the configuration file, the source, and the sourcetype of
     * the indexed data. If the value is "localhost", it will use native event
     * log collection; otherwise, it will use WMI.
     *
     * @return The collection name.
     */
    public String getLocalName() {
        return getString("name");
    }

    /**
     * Returns the main host of this Windows Event Log input. Secondary hosts are
     * specified in the {@code hosts} attribute.
     * @see #getHosts
     *
     * @return The main host.
     */
    public String getLookupHost() {
        return getString("lookup_host");
    }
}