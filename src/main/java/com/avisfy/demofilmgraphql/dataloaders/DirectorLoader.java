package com.avisfy.demofilmgraphql.dataloaders;

import com.avisfy.demofilmgraphql.services.DirectorService;
import com.avisfy.demofilmgraphql.types.Director;
import com.netflix.graphql.dgs.DgsDataLoader;
import lombok.AllArgsConstructor;
import org.dataloader.BatchLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "directedBy")
@AllArgsConstructor
public class DirectorLoader implements BatchLoader<Integer, Director> {
    private final DirectorService directorService;
    @Override
    public CompletionStage<List<Director>> load(List<Integer> list) {
        return CompletableFuture.supplyAsync(()->directorService.directorsByIds(list));
    }
}
