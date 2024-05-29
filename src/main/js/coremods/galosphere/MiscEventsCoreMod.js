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
    ASMAPI.log('DEBUG', 'Removing visible annotations from method: {}.{} in class net.orcinus.galosphere.events.MiscEvents', method.name, method.desc);
    method.visibleAnnotations.clear();

    ASMAPI.log('DEBUG', '{}.{}\n{}', 'net.orcinus.galosphere.events.MiscEvents', method.name, ASMAPI.methodNodeToString(method));
    return method;
}
