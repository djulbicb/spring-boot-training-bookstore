package com.training.bookstore.service.statics;

import com.pocketknife.resource.JsonToClassReader;
import com.training.bookstore.model.statics.StaticHtmlPage;

import java.util.List;

public class StaticPageConsumer extends JsonToClassReader<List<StaticHtmlPage>> {
    @Override
    public String getResourceFilePath() {
        return null;
    }
}
