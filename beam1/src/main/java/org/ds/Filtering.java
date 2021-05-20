package org.ds;


import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;

import java.util.Arrays;
import java.util.List;

public class Filtering {
    public static class FilteringThresholdFn extends DoFn<Double, Double> {
        private double threshold = 0;

        public FilteringThresholdFn(double threshold) {
            this.threshold = threshold;
        }

        @ProcessElement
        public void processElement(ProcessContext c) {
            if(c.element() > threshold) {
                c.output(c.element());
            }
        }
    }

    public static void main(String... args) {
        PipelineOptions options = PipelineOptionsFactory.create();
        Pipeline pipeline = Pipeline.create(options);

        List<Double> stockPrices = Arrays.asList(1.232, 23.232, 2434.4, 334.44, 334.5, 2334.34);

        pipeline.apply(Create.of(stockPrices))
                .apply(MapElements.via(new SimpleFunction<Double, Double>() {
                    @Override
                    public Double apply(Double input) {
                        System.out.println("-pre-filtered: " + input);
                        return input;
                    }
                }))
                .apply(ParDo.of(new FilteringThresholdFn(334.45)))
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
