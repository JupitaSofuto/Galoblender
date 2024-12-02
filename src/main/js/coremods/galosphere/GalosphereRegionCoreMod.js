var Opcodes = Java.type('org.objectweb.asm.Opcodes');
var AbstractInsnNode = Java.type('org.objectweb.asm.tree.AbstractInsnNode');
var FieldInsnNode = Java.type('org.objectweb.asm.tree.FieldInsnNode');
var LocalVariableNode = Java.type('org.objectweb.asm.tree.LocalVariableNode');
var VarInsnNode = Java.type('org.objectweb.asm.tree.VarInsnNode');

var ASMAPI = Java.type('net.minecraftforge.coremod.api.ASMAPI');

function initializeCoreMod() {
    return {
        'constructorWithWeight': {
            'target': {
                'type': 'CLASS',
                'name': 'net.orcinus.galosphere.compat.integration.terrablender.GalosphereRegion'
            },
            'transformer': constructorWithWeight
        }
    };
}

function constructorWithWeight(clazz) {
    // find the constructor
    var method;
    for (var i = 0; i < clazz.methods.size(); i++) {
        method = clazz.methods.get(i);
        if (method.name === '<init>' && method.desc === '()V') {
            break;
        }
    }

    // create our method
    var constructor = clazz.visitMethod(method.access, method.name, '(I)V', method.signature, null);
    method.accept(constructor);

    // get start label
    var start = null;
    for (var i = 0; i < constructor.instructions.size(); i++) {
        var insn = constructor.instructions.get(i);
        if (insn.getType() === AbstractInsnNode.LABEL) {
            start = insn;
            break;
        }
    }

    // get end label
    var end = null;
    for (var i = constructor.instructions.size() - 1; i >= 0; i--) {
        var insn = constructor.instructions.get(i);
        if (insn.getType() === AbstractInsnNode.LABEL) {
            end = insn;
            break;
        }
    }

    // replace ICONST_1 (int literal 1) with ILOAD_1
    var constant = ASMAPI.findFirstInstruction(constructor, Opcodes.ICONST_1);
    constructor.instructions.insert(constant, new VarInsnNode(Opcodes.ILOAD, 1));
    constructor.instructions.remove(constant);

    // add our new constructor parameter to the local variables
    constructor.localVariables.add(new LocalVariableNode('weight', 'I', null, start, end, 1));
    constructor.maxLocals++;

    // finish up
    return clazz;
}
