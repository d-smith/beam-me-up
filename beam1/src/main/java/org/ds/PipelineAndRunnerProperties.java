package org.ds;

import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class PipelineAndRunnerProperties {
    public static void main(String... args) {
        PipelineOptions options = PipelineOptionsFactory.create();

        System.out.println("runner: " + options.getRunner().getName());
        System.out.println("job name: " + options.getJobName());
        System.out.println("options id: " + options.getOptionsId());
        System.out.println("stable unique names: " + options.getStableUniqueNames());
        System.out.println("temp output: " + options.getTempLocation());
        System.out.println("user agent: " + options.getUserAgent());
    }
}