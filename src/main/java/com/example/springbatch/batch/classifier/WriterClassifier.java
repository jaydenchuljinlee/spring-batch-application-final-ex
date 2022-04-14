package com.example.springbatch.batch.classifier;

import com.example.springbatch.batch.domain.ApiRequestVO;
import com.example.springbatch.batch.domain.ProductVO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.classify.Classifier;

import java.util.HashMap;
import java.util.Map;

public class WriterClassifier<C, T> implements Classifier<C, T> {

    private Map<String, ItemWriter<ApiRequestVO>> writerMap = new HashMap<>();

    public void setWriterMap(Map<String, ItemWriter<ApiRequestVO>> writerMap) {
        this.writerMap = writerMap;
    }

    @Override
    public T classify(C classifiable) {

        return (T) writerMap.get(((ApiRequestVO)classifiable).getProductVO().getType());
    }
}
