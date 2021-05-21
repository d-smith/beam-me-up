package org.ds;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.Mean;
import org.apache.beam.sdk.transforms.SimpleFunction;

import java.util.Arrays;
import java.util.List;

public class Aggregation {

    public static void main(String... args) {
        PipelineOptions options = PipelineOptionsFactory.create();
        Pipeline pipeline = Pipeline.create(options);

        List<Double> stockPrices = Arrays.asList(1.232, 23.232, 2434.4, 334.44, 334.5, 2334.34);

        pipeline.apply(Create.of(stockPrices))
                .apply(Mean.<Double>globally())
                .apply(MapElements.via(new SimpleFunction<Double, Double>() {
                    @Override
                    public Double apply(Double input) {
                        System.out.println("-post-filtered: " + input);
                        return input;
                    }
                }));
        pipeline.run();
    }
}
