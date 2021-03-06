/*
 * Copyright 2016, Stuart Douglas, and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.fakereplace.integration.wildfly;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fakereplace.api.Extension;
import org.fakereplace.transformation.FakereplaceTransformer;

public class WildflyExtension implements Extension {

    public static final String RESOURCE_CACHE_CLASS = "org.apache.naming.resources.ResourceCache";

    private static final String CLASS_CHANGE_AWARE = "org.fakereplace.integration.wildfly.WildflyClassChangeAware";
    public static final String JBOSSAS_ENVIRONMENT = "org.fakereplace.integration.wildfly.WildflyEnvironment";

    @Override
    public String getClassChangeAwareName() {
        return CLASS_CHANGE_AWARE;
    }

    @Override
    public Set<String> getIntegrationTriggerClassNames() {
        return new HashSet<>(Arrays.asList("org.jboss.as.server.ApplicationServerService", "org.wildfly.extension.undertow.deployment.UndertowDeploymentInfoService"));
    }

    @Override
    public String getEnvironment() {
        return JBOSSAS_ENVIRONMENT;
    }

    @Override
    public Set<String> getTrackedInstanceClassNames() {
        return new HashSet<String>(Arrays.asList(new String[]{RESOURCE_CACHE_CLASS}));
    }

    @Override
    public List<FakereplaceTransformer> getTransformers() {
        return Collections.singletonList(new WildflyClassTransformer());
    }

}
