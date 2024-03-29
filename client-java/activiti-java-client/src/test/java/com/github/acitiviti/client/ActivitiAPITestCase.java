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

package com.github.acitiviti.client;

import java.io.File;

import okhttp3.logging.HttpLoggingInterceptor;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

import retrofit2.Response;

public abstract class ActivitiAPITestCase
{
    // ///////////////////////////////////////////////////////////////////////////
    // CONSTANTS
    // ///////////////////////////////////////////////////////////////////////////
    public static final boolean ENABLE_HTTP_LOGGING = true;

    // Endpoint must end with "/" like
    // https://activiti.alfresco.com/activiti-app/
    public static final String TEST_ENDPOINT = "http://10.50.102.14:8080/activiti-rest/";

    public static final String TEST_USERNAME = "kermit";

    public static final String TEST_PASSWORD = "kermit";

    // ///////////////////////////////////////////////////////////////////////////
    // VARIABLES
    // ///////////////////////////////////////////////////////////////////////////
    protected Logger logger = null;

    protected BPMClient client;

    protected File tmpFolder;

    // ///////////////////////////////////////////////////////////////////////////
    // LOGGING
    // ///////////////////////////////////////////////////////////////////////////
    @BeforeClass
    public void prepareLogger() throws Exception
    {
        Class<? extends ActivitiAPITestCase> currTestClass = getClass();
        this.logger = Logger.getLogger(currTestClass);
        String message = "Started executing class " + this.getClass().getName();
        logger.info(message);
    }

    // ///////////////////////////////////////////////////////////////////////////
    // ALFRESCO CLIENT UTILS
    // ///////////////////////////////////////////////////////////////////////////
    public void prepareDefaultClient()
    {
        client = new BPMClient.Builder().connect(TEST_ENDPOINT, TEST_USERNAME, TEST_PASSWORD)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    public BPMClient prepareClient(String endpoint, String username, String password)
    {
        return new BPMClient.Builder().connect(endpoint, username, password)
                .httpLogging(HttpLoggingInterceptor.Level.BODY).build();
    }

    // ///////////////////////////////////////////////////////////////////////////
    // FILE MANAGEMENT
    // ///////////////////////////////////////////////////////////////////////////
    public void checkResourceFile(String path)
    {
        Assert.assertNotNull(getClass().getResource(path), "Resource file missing : " + path);
    }

    public File getResourceFile(String path)
    {
        return new File(getClass().getResource(path).getFile());
    }

    // ///////////////////////////////////////////////////////////////////////////
    // RESPONSE CHECK
    // ///////////////////////////////////////////////////////////////////////////
    public void hasSuceedReponse(Response response)
    {
        Assert.assertNotNull(response);
        Assert.assertEquals(response.isSuccessful(), true, response.message());
    }

}