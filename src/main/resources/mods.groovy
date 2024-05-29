ModsDotGroovy.make {
    modLoader = 'javafml'
    loaderVersion = this.buildProperties.loader_version_range
    license = this.buildProperties.mod_license

    mod {
        modId = this.buildProperties.mod_id
        version = this.buildProperties.mod_version
        displayName = this.buildProperties.mod_name
        displayUrl = 'https://www.curseforge.com/minecraft/modpacks/genesis-pack'
        logoFile = 'icon.png'
        credits = "${this.buildProperties.mod_vendor}"
        authors = ['Jonathing']
        displayTest = DisplayTest.MATCH_VERSION
        description = '''A module from Genesis: Core that repairs Galosphere compatibility with Terrablender.'''

        catalogueImageIcon = 'icon.png'
        catalogueBackground = 'background.png'

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