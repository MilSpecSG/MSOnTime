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

package org.anvilpowered.ontime.api.member;

import jetbrains.exodus.entitystore.Entity;
import jetbrains.exodus.entitystore.EntityId;
import jetbrains.exodus.entitystore.PersistentEntityStore;
import jetbrains.exodus.entitystore.StoreTransaction;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface XodusMemberRepository extends MemberRepository<EntityId, PersistentEntityStore> {

    Function<? super StoreTransaction, ? extends Iterable<Entity>> asQuery(UUID userUUID);

    CompletableFuture<Boolean> addTime(
        Function<? super StoreTransaction, ? extends Iterable<Entity>> query, long time);

    CompletableFuture<Boolean> addBonusTime(
        Function<? super StoreTransaction, ? extends Iterable<Entity>> query, long time);

    CompletableFuture<Boolean> setBonusTime(
        Function<? super StoreTransaction, ? extends Iterable<Entity>> query, long time);

    CompletableFuture<Boolean> setTotalTime(
        Function<? super StoreTransaction, ? extends Iterable<Entity>> query, long time);
}
