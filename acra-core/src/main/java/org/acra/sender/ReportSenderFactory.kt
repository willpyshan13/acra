/*
 * Copyright (c) 2017 the ACRA team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.acra.sender

import android.content.Context
import org.acra.config.CoreConfiguration
import org.acra.plugins.Plugin

/**
 * Factory for creating and configuring a [ReportSender] instance.
 * Implementations must have a no argument constructor.
 *
 *
 * Each configured ReportSenderFactory is created within the [LegacySenderService]
 * and is used to construct and configure a single [ReportSender].
 *
 *
 * Created by William on 4-JAN-2016.
 */
interface ReportSenderFactory : Plugin {
    /**
     * @param context a context.
     * @param config  Configuration to use when sending reports.
     * @return Fully configured instance of the relevant ReportSender.
     */
    fun create(context: Context, config: CoreConfiguration): ReportSender
}