/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.github.acitiviti.client.model.runtime.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.acitiviti.client.model.common.AbstractRepresentation;
import com.github.acitiviti.client.model.runtime.RestVariable;
import lombok.Data;

/**
 * 
 * @author joezou
 * @date 2019/7/16 16:56
 **/
@Data
public class ProcessInstanceRepresentation extends AbstractRepresentation
{
    protected String id;

    protected String url;

    protected String businessKey;

    protected boolean suspended;

    protected boolean ended;

    protected String processDefinitionId;

    protected String tenantId;

    protected String processDefinitionUrl;

    protected String processDefinitionKey;

    protected String activityId;

    protected String name;

    protected boolean completed;

    protected List<RestVariable> variables = new ArrayList<RestVariable>();

    public ProcessInstanceRepresentation()
    {
    }
}
