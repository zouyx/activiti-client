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

package com.github.client.api.model.runtime.response;

import com.github.client.api.model.common.AbstractRepresentation;
import com.github.client.api.model.idm.response.LightUserRepresentation;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by jpascal on 12/12/2014.
 */
@Data
public class TaskRepresentation extends AbstractRepresentation
{
    protected String id;

    protected String name;

    protected String description;

    protected String category;

    protected String assignee;

    protected Date created;

    protected Date dueDate;

    protected Date endDate;

    protected Long duration;

    protected Integer priority;

    protected String processInstanceId;

    protected String processInstanceName;

    protected String processDefinitionId;

    protected String processDefinitionName;

    protected String processDefinitionDescription;

    protected String processDefinitionKey;

    protected String processDefinitionCategory;

    protected Integer processDefinitionVersion;

    protected String processDefinitionDeploymentId;

    protected String formKey;

    protected String processInstanceStartUserId;

    protected Boolean initiatorCanCompleteTask;

    protected Boolean isMemberOfCandidateGroup;

    protected Boolean isMemberOfCandidateUsers;

    protected String parentTaskId;

    protected String parentTaskName;

    protected Boolean adhocTaskCanBeReassigned;

}
