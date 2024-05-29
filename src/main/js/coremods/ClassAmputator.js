var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');

function initializeCoreMod() {
    return {
        'galosphere$MiscEvents': {
            'target': {
                'type': 'CLASS',
                'name': 'net.orcinus.galosphere.events.MiscEvents'
            },
            'transformer': function (clazz) {
                removeMethodVisibleAnnotations(clazz, 'onParallelDispatched', '(Lnet/minecraftforge/fml/event/lifecycle/ParallelDispatchEvent;)V');

                ASMAPI.log('TRACE', '{}\n{}', clazz.name.replaceAll('/', '.'), ASMAPI.classNodeToString(clazz));
                return clazz;
            }
        }
    };
}

function removeMethod(clazz, name, desc) {
    for (var i = 0; i < clazz.methods.size(); i++) {
        var method = clazz.methods.get(i);
        if (method.name === name && method.desc === desc) {
            ASMAPI.log('DEBUG', 'Removing method: {}.{} from class {}', method.name, method.desc, clazz.name.replaceAll('/', '.'));
            clazz.methods.remove(i);
            break;
        }
    }

    // we're done here
    return clazz;
}

/**
 * Removes all visible annotations from the given method.
 *
 * @param method the MethodNode to transform
 * @returns {*}  the transformed method
 */
function removeMethodVisibleAnnotations(clazz, name, desc) {
    for (var i = 0; i < clazz.methods.size(); i++) {
        var method = clazz.methods.get(i);
        if (method.name === name && method.desc === desc) {
            ASMAPI.log('DEBUG', 'Removing visible annotations from method: {}.{} in class {}', method.name, method.desc, clazz.name.replaceAll('/', '.'));
            method.visibleAnnotations.clear();
            break;
        }
    }

    // we're done here
    return method;
}
