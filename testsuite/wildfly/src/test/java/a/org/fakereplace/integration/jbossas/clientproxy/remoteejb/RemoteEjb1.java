/*
 * Copyright 2012, Stuart Douglas, and individual contributors as indicated
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package a.org.fakereplace.integration.jbossas.clientproxy.remoteejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Stuart Douglas
 */
@Stateless
public class RemoteEjb1 implements RemoteInterface {

    @Inject
    private AppScopedBean1 appScopedBean;

    public String getValue() {
        return appScopedBean.getValue();
    }

    public void setValue(String value) {
        appScopedBean.setValue(value);
    }
}