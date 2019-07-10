package com.example;

import org.killbill.billing.osgi.api.OSGIPluginProperties;
import org.killbill.billing.osgi.libs.killbill.KillbillActivatorBase;
import org.killbill.billing.usage.plugin.api.UsagePluginApi;
import org.osgi.framework.BundleContext;

import java.util.Hashtable;

public class UsageApiActivator extends KillbillActivatorBase {

    public static final String PLUGIN_NAME = "killbill-usage-api-plugin";

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);

        final UsageApi usageApi = new UsageApi(logService);
        registerUsagePluginApi(context, usageApi);
    }

    private void registerUsagePluginApi(final BundleContext context, final UsagePluginApi api) {
        final Hashtable<String, String> props = new Hashtable<String, String>();
        props.put(OSGIPluginProperties.PLUGIN_NAME_PROP, PLUGIN_NAME);
        registrar.registerService(context, UsagePluginApi.class, api, props);
    }
}
