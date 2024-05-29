ModsDotGroovy.make {
    modLoader = 'javafml'
    loaderVersion = this.buildProperties.loader_version_range
    license = this.buildProperties.mod_license

    mod {
        modId = this.buildProperties.mod_id
        version = this.buildProperties.mod_version
        displayName = this.buildProperties.mod_name
        displayUrl = 'https://www.curseforge.com/minecraft/mc-mods/galoblender'
        logoFile = 'logo.png'
        credits = "${this.buildProperties.mod_vendor}"
        authors = ['Jonathing']
        displayTest = DisplayTest.MATCH_VERSION
        description = '''Repairs Galosphere compatibility with Terrablender. Made for GENESIS.'''

        catalogueImageIcon = 'icon.png'

        dependencies {
            minecraft = this.buildProperties.mc_version_range
            forge = this.buildProperties.forge_version_range

            mod('galosphere') {
                mandatory = true
                versionRange = this.buildProperties.galosphere_version_range
                ordering = DependencyOrdering.NONE
                side = DependencySide.BOTH
            }

            mod('terrablender') {
                mandatory = true
                versionRange = this.buildProperties.terrablender_version_range
                ordering = DependencyOrdering.NONE
                side = DependencySide.BOTH
            }
        }
    }
}