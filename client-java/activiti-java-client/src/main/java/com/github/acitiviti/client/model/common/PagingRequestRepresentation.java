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
package com.github.acitiviti.client.model.common;

/**
 * Created by jpascal on 12/03/2015.
 */
public class PagingRequestRepresentation
{
    final String sort;

    final String state;

    final Long page;

    final Long size;

    public PagingRequestRepresentation(String state, String sort, Long page, Long size)
    {
        this.state = state;
        this.size = size;
        this.sort = sort;
        this.page = page;
    }
}
