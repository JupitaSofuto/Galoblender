var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');

function initializeCoreMod() {
    return {
        'disableOnParallelDispatched': {
            'target': {
                'type': 'METHOD',
                'class': 'net.orcinus.galosphere.events.MiscEvents',
                'methodName': 'onParallelDispatched',
                'methodDesc': '(Lnet/minecraftforge/fml/event/lifecycle/ParallelDispatchEvent;)V'
            },
            'transformer': disableOnParallelDispatched
        }
    };
}

function disableOnParallelDispatched(method) {
    // clear visible annotations, which deletes @SubscribeEvent
    method.visibleAnnotations.clear();

    // finish up
    ASMAPI.log('TRACE', '{}.{}\n{}', 'net.orcinus.galosphere.events.MiscEvents', method.name, ASMAPI.methodNodeToString(method));
    return method;
}
