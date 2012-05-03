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

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code EventTypeCollection} class represents a collection of event types.
 */
public class EventTypeCollection extends EntityCollection<EventType> {

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     */
    EventTypeCollection(Service service) {
        super(service, "saved/eventtypes", EventType.class);
    }

    /**
     * Class Constructor.
     *
     * @param service The connected service instance.
     * @param args Arguments use at instantiation, such as count and offset.
     */
    EventTypeCollection(Service service, Args args) {
        super(service, "saved/eventtypes", EventType.class, args);
    }

    /**
     * Class Constructor.
     *
     * @param service The connected service instance.
     * @param namespace This collection's namespace.
     */
    EventTypeCollection(Service service, HashMap<String, String> namespace) {
        super(service, "saved/eventtypes", EventType.class, namespace);
    }

    /**
     * Class Constructor.
     *
     * @param service The connected service instance.
     * @param args Arguments use at instantiation, such as count and offset.
     * @param namespace This collection's namespace.
     */
    EventTypeCollection(
            Service service, Args args, HashMap<String, String> namespace) {
        super(service, "saved/eventtypes", EventType.class, args, namespace);
    }

    /**
     * Creates an event type.
     *
     * @param name The name of this new event type.
     * @param search The search string of this new event type.
     *
     * @return The event type.
     */
    public EventType create(String name, String search) {
        return create(name, search, null);
    }

    /**
     * Creates an event type.
     *
     * @param name The name of this new event type.
     * @param search The search string of this new event type.
     * @param args Optional arguments.
     * @return The event type.
     */
    public EventType create(String name, String search, Map args) {
        args = Args.create(args).add("search", search);
        return create(name, args);
    }
}