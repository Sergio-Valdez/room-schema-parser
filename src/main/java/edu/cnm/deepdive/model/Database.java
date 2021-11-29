package edu.cnm.deepdive.model;

import com.google.gson.annotations.Expose;
import java.util.List;
import java.util.stream.Stream;

public class Database implements StreamableDdl {

  @Expose
  List<Entity> entities;

  @Expose
  List<View> views;

  public List<Entity> getEntities() {
    return entities;
  }

  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  public List<View> getViews() {
    return views;
  }

  public void setViews(List<View> views) {
    this.views = views;
  }

  @Override
  public Stream<String> streamDdl() {
    return Stream
        .concat(
            entities.stream(),
            views.stream()
        )
        .flatMap(StreamableDdl::streamDdl);
  }
}