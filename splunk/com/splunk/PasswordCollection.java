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

/**
 * The {@code PasswordCollection} class represents a collection of credentials.
 */
public class PasswordCollection extends EntityCollection<Password> {

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     */
    PasswordCollection(Service service) {
        // Starting with 4.3 this is available at "storage/passwords"
        super(service, "admin/passwords", Password.class);
    }

    /**
     * Class Constructor.
     *
     * @param service The connected service instance.
     * @param args Arguments use at instantiation, such as count and offset.
     */
    PasswordCollection(Service service, Args args) {
        // Starting with 4.3 this is available at "storage/passwords"
        super(service, "admin/passwords", Password.class, args);
    }

    /**
     * Class Constructor.
     *
     * @param service The connected service instance.
     * @param namespace This collection's namespace.
     */
    PasswordCollection(Service service, HashMap<String, String> namespace) {
        // Starting with 4.3 this is available at "storage/passwords"
        super(service, "admin/passwords", Password.class, namespace);
    }

    /**
     * Class Constructor.
     *
     * @param service The connected service instance.
     * @param args Arguments use at instantiation, such as count and offset.
     * @param namespace This collection's namespace.
     */
    PasswordCollection(
            Service service, Args args, HashMap<String, String> namespace) {
        // Starting with 4.3 this is available at "storage/passwords"
        super(service, "admin/passwords", Password.class, args, namespace);
    }

    /**
     * Creates a credential with a username and password.
     *
     * @param name The username.
     * @param password The password.
     *
     * @return The new credential.
     */
    public Password create(String name, String password) {
        Args args = new Args("password", password);
        return create(name, args);
    }

    /**
     * Creates a credential with a username, password, and realm.
     *
     * @param name The username.
     * @param password The password.
     * @param realm The credential realm.
     * @return The new credential.
     */
    public Password create(String name, String password, String realm) {
        Args args = new Args();
        args.put("password", password);
        args.put("realm", realm);
        return create(name, args);
    }

    /**
     * Returns the username for a credential.
     *
     * @param entry The Atom object describing the credential.
     * @return The username.
     */
    @Override protected String itemKey(AtomEntry entry) {
        return (String)entry.content.get("username");
    }
}