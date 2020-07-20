package ru.mosreg.tenant.provider;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProvider;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderCaseInstanceContext;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderHistoricDecisionInstanceContext;
import org.camunda.bpm.engine.impl.cfg.multitenancy.TenantIdProviderProcessInstanceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomTenantIdProvider implements TenantIdProvider, ProcessEnginePlugin {
    private final Logger logger = LoggerFactory.getLogger(CustomTenantIdProvider.class.getName());

    @Override
    public String provideTenantIdForProcessInstance(TenantIdProviderProcessInstanceContext ctx) {
        return getTenantIdOfCurrentAuthentication();
    }

    @Override
    public String provideTenantIdForCaseInstance(TenantIdProviderCaseInstanceContext ctx) {
        return getTenantIdOfCurrentAuthentication();
    }

    @Override
    public String provideTenantIdForHistoricDecisionInstance(TenantIdProviderHistoricDecisionInstanceContext ctx) {
        return getTenantIdOfCurrentAuthentication();
    }

    protected String getTenantIdOfCurrentAuthentication() {
//        IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
//        Authentication currentAuthentication = identityService.getCurrentAuthentication();
//        if (currentAuthentication != null) {
//
//            List<String> tenantIds = currentAuthentication.getTenantIds();
//            if (tenantIds.size() == 1) {
//                return tenantIds.get(0);
//
//            } else if (tenantIds.isEmpty()) {
//                throw new IllegalStateException("no authenticated tenant");
//
//            } else {
//                throw new IllegalStateException("more than one authenticated tenant");
//            }
//
//        } else {
//            throw new IllegalStateException("no authentication");
//        }

        return "qqqwwweee";
    }

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

    }

    @Override
    public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

    }

    @Override
    public void postProcessEngineBuild(ProcessEngine processEngine) {

    }
}
