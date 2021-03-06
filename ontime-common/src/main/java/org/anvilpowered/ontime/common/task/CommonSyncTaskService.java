/*
 *   OnTime - AnvilPowered
 *   Copyright (C) 2020
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anvilpowered.ontime.common.task;

import com.google.inject.Inject;
import org.anvilpowered.anvil.api.registry.Registry;
import org.anvilpowered.ontime.api.task.SyncTaskService;
import org.slf4j.Logger;

public abstract class CommonSyncTaskService implements SyncTaskService {

    protected static final String MULTIPLIER_META_KEY = "ontime-multiplier";

    @Inject
    protected Logger logger;

    protected Registry registry;

    protected CommonSyncTaskService(Registry registry) {
        this.registry = registry;
        this.registry.whenLoaded(this::whenLoaded).register();
    }

    private void whenLoaded() {
        stopSyncTask();
        startSyncTask();
    }
}
