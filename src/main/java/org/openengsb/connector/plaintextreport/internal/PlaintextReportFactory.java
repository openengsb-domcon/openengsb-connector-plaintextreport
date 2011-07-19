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

import java.util.Map;

import org.openengsb.core.api.Connector;
import org.openengsb.core.api.ekb.EngineeringKnowledgeBaseService;
import org.openengsb.core.common.AbstractConnectorInstanceFactory;
import org.openengsb.domain.report.ReportDomainEvents;
import org.openengsb.domain.report.common.ReportStoreFactory;

public class PlaintextReportFactory extends AbstractConnectorInstanceFactory<PlaintextReportService> {

    private final ReportStoreFactory storeFactory;
    
    @SuppressWarnings("unused")
    private ReportDomainEvents reportEvents;
    @SuppressWarnings("unused")
    private EngineeringKnowledgeBaseService ekbService;

    public PlaintextReportFactory(ReportStoreFactory storeFactory) {
        this.storeFactory = storeFactory;
    }

    @Override
    public Connector createNewInstance(String id) {
        PlaintextReportService service = new PlaintextReportService(id);
        service.setStore(storeFactory.createReportStore(id));
        return service;
    }

    @Override
    public void doApplyAttributes(PlaintextReportService instance, Map<String, String> attributes) {
        // do nothing - currently no attributes defined
    }
    
    public void setEkbService(EngineeringKnowledgeBaseService ekbService) {
        this.ekbService = ekbService;
    }

    public void setReportEvents(ReportDomainEvents reportEvents) {
        this.reportEvents = reportEvents;
    }
}
