/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openengsb.connector.plaintextreport.internal;

import java.util.HashMap;
import java.util.Map;

import org.openengsb.core.api.ServiceInstanceFactory;
import org.openengsb.core.api.descriptor.ServiceDescriptor;
import org.openengsb.core.api.descriptor.ServiceDescriptor.Builder;
import org.openengsb.core.api.validation.MultipleAttributeValidationResult;
import org.openengsb.core.api.validation.MultipleAttributeValidationResultImpl;
import org.openengsb.domain.report.ReportDomain;
import org.openengsb.domain.report.common.ReportStoreFactory;

public class PlaintextReportFactory implements ServiceInstanceFactory<ReportDomain, PlaintextReportService> {

    private final ReportStoreFactory storeFactory;

    public PlaintextReportFactory(ReportStoreFactory storeFactory) {
        this.storeFactory = storeFactory;
    }

    @Override
    public ServiceDescriptor getDescriptor(Builder builder) {
        builder.name("plaintextReport.name").description("plaintextReport.description");
        return builder.build();
    }

    @Override
    public void updateServiceInstance(PlaintextReportService instance, Map<String, String> attributes) {
        setAttributes(instance, attributes);
    }

    @Override
    public PlaintextReportService createServiceInstance(String id, Map<String, String> attributes) {
        PlaintextReportService service = new PlaintextReportService(id);
        service.setStore(storeFactory.createReportStore(id));
        setAttributes(service, attributes);
        return service;
    }

    private void setAttributes(PlaintextReportService service, Map<String, String> attributes) {
        // do nothing - currently no attributes defined
    }

    @Override
    public MultipleAttributeValidationResult updateValidation(PlaintextReportService instance,
            Map<String, String> attributes) {
        return new MultipleAttributeValidationResultImpl(true, new HashMap<String, String>());
    }

    @Override
    public MultipleAttributeValidationResult createValidation(String id, Map<String, String> attributes) {
        return new MultipleAttributeValidationResultImpl(true, new HashMap<String, String>());
    }

}
