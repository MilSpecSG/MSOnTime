package rocks.milspecsg.msontime.api.member.repository;

import rocks.milspecsg.msontime.model.core.member.Member;
import rocks.milspecsg.msrepository.api.cache.CacheService;
import rocks.milspecsg.msrepository.api.repository.Repository;
import rocks.milspecsg.msrepository.datastore.DataStoreConfig;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface MemberRepository<
    TKey,
    TDataStore,
    TDataStoreConfig extends DataStoreConfig>
    extends Repository<TKey, Member<TKey>, CacheService<TKey, Member<TKey>, TDataStore, TDataStoreConfig>, TDataStore, TDataStoreConfig> {

    CompletableFuture<Optional<Member<TKey>>> getOneOrGenerateForUser(UUID userUUID);

    CompletableFuture<Optional<Member<TKey>>> getOneForUser(UUID userUUID);

    CompletableFuture<Boolean> addMinuteForUser(UUID userUUID);
}