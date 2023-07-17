package zaldivar.carlos.libapklispaidchequed

/**
 * Data class para si Apklist tiene nueva version
 * @author cz9dev by Carlos Zaldívar
 */
data class HasUpdate(
    var update_exist: Boolean,
    var version_name: String?
)
