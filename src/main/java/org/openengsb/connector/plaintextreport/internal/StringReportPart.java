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

import java.util.List;

import org.openengsb.core.api.model.OpenEngSBModelEntry;
import org.openengsb.domain.report.model.ReportPart;

public class StringReportPart implements ReportPart {

    private String content;
    private String partName;
    private String contentType;

    public StringReportPart(String partName, String contentType, String content) {
        this.content = content;
        this.contentType = contentType;
        this.partName = partName;
    }

    @Override
    public byte[] getContent() {
        return content.getBytes();
    }
    
    @Override
    public void setPartName(String partName) {
        this.partName = partName;
    }
    
    @Override
    public String getPartName() {
        return partName;
    }
    
    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    @Override
    public String getContentType() {
        return contentType;
    }
    
    @Override
    public void setContent(byte[] content) {
    }

    @Override
    public void addOpenEngSBModelEntry(OpenEngSBModelEntry arg0) {
    }

    @Override
    public List<OpenEngSBModelEntry> getOpenEngSBModelEntries() {
        return null;
    }

    @Override
    public void removeOpenEngSBModelEntry(String arg0) {
    }
}
