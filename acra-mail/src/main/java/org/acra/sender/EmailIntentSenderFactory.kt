/*
 * Copyright (c) 2017
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
import com.google.auto.service.AutoService
import org.acra.config.CoreConfiguration
import org.acra.config.MailSenderConfiguration
import org.acra.plugins.HasConfigPlugin

/**
 * Constructs an [EmailIntentSender].
 */
@AutoService(ReportSenderFactory::class)
class EmailIntentSenderFactory : HasConfigPlugin(MailSenderConfiguration::class.java), ReportSenderFactory {
    override fun create(context: Context, config: CoreConfiguration): ReportSender = EmailIntentSender(config)
}