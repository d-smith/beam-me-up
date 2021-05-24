package org.ds;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;

public class StockPricePercentageDeltaComputation {
    private static final String CSV_HEADER=
            "Date,Open,High,Low,Close,Adj Close,Adj Volume,Name";

    public interface ComputationOptions extends PipelineOptions {
        @Description("path to files")
        @Default.String("src/main/resources/streaming_source/*.csv")
        String getInputFile();

        void setInputFile(String input);

        @Description("Path of file to write to")
        @Validation.Required
        @Default.String("src/main/resources/sink/percentage_delta")
        String getOutputFile();

        void setOutputFile(String value);
    }
}
