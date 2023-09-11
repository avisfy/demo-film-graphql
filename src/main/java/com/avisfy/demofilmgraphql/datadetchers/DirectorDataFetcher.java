package com.avisfy.demofilmgraphql.datadetchers;

import com.avisfy.demofilmgraphql.dataloaders.DirectorLoader;
import com.avisfy.demofilmgraphql.types.Director;
import com.avisfy.demofilmgraphql.types.Film;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

@DgsComponent
@AllArgsConstructor
public class DirectorDataFetcher {
    @DgsData(parentType = "Film",field = "directedBy")
    public CompletableFuture<Director> director(DgsDataFetchingEnvironment dfe) {
        DataLoader<Integer, Director> dataLoader = dfe.getDataLoader(DirectorLoader.class);
        Film film = dfe.getSource();
        return dataLoader.load(film.getDirectedById());
    }
}
