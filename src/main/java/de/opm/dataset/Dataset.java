package de.opm.dataset;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.opm.dataset.cases.Case;
import de.opm.dataset.cases.Cases;
import de.opm.dataset.output.Output;
import de.opm.dataset.time.Timesequence;
import de.opm.template.variants.Variant;
import de.opm.template.variants.Variants;
import de.opm.ui.VariantQuantitiy;

public class Dataset {

    /**
     * Start building the Dataset. The ammount for each Variant is read from the UI
     */
    public static void buildDataset(VariantQuantitiy[] inputs){

        List<Case> cases = new ArrayList<Case>();
        for(VariantQuantitiy input : inputs){
            String variant_key = input.getVariantKey();
            Variant variant = Variants.getVariantByKey(variant_key);
            Timesequence case_begin = new Timesequence(new Date().getTime(), 1);
            for(int quant = input.getQuantity() ; quant > 0 ; quant--){
                long case_start = case_begin.getNextTimestamp();
                Case case_ = Cases.getCase(variant, case_start);

                cases.add(case_);
            }
        }

        int list_size = cases.size();
        Case[] cases_arr = cases.toArray(new Case[list_size]);
        Output.pritToLogfile(cases_arr);
    }
}
