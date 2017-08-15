package com.opsgenie.tools.backup.exporters;

import com.opsgenie.client.ApiException;
import com.opsgenie.client.api.EscalationApi;
import com.opsgenie.client.model.Escalation;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class EscalationExporter extends BaseExporter<Escalation> {

    private static EscalationApi escalationApi = new EscalationApi();

    public EscalationExporter(String backupRootDirectory) {
        super(backupRootDirectory, "escalations");
    }

    @Override
    protected String getBeanFileName(Escalation escalation) {
        return escalation.getName() + "-" + escalation.getId();
    }


    @Override
    protected List<Escalation> retrieveEntities() throws ParseException, IOException, ApiException {
        return escalationApi.listEscalations().getData();
    }
}
