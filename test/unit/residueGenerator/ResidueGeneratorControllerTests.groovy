package residueGenerator


import org.junit.*
import grails.test.mixin.*

@TestFor(ResidueGeneratorController)
@Mock(ResidueGenerator)
class ResidueGeneratorControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/residueGenerator/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.residueGeneratorInstanceList.size() == 0
        assert model.residueGeneratorInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.residueGeneratorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.residueGeneratorInstance != null
        assert view == '/residueGenerator/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/residueGenerator/show/1'
        assert controller.flash.message != null
        assert ResidueGenerator.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/residueGenerator/list'

        populateValidParams(params)
        def residueGenerator = new ResidueGenerator(params)

        assert residueGenerator.save() != null

        params.id = residueGenerator.id

        def model = controller.show()

        assert model.residueGeneratorInstance == residueGenerator
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/residueGenerator/list'

        populateValidParams(params)
        def residueGenerator = new ResidueGenerator(params)

        assert residueGenerator.save() != null

        params.id = residueGenerator.id

        def model = controller.edit()

        assert model.residueGeneratorInstance == residueGenerator
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/residueGenerator/list'

        response.reset()

        populateValidParams(params)
        def residueGenerator = new ResidueGenerator(params)

        assert residueGenerator.save() != null

        // test invalid parameters in update
        params.id = residueGenerator.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/residueGenerator/edit"
        assert model.residueGeneratorInstance != null

        residueGenerator.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/residueGenerator/show/$residueGenerator.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        residueGenerator.clearErrors()

        populateValidParams(params)
        params.id = residueGenerator.id
        params.version = -1
        controller.update()

        assert view == "/residueGenerator/edit"
        assert model.residueGeneratorInstance != null
        assert model.residueGeneratorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/residueGenerator/list'

        response.reset()

        populateValidParams(params)
        def residueGenerator = new ResidueGenerator(params)

        assert residueGenerator.save() != null
        assert ResidueGenerator.count() == 1

        params.id = residueGenerator.id

        controller.delete()

        assert ResidueGenerator.count() == 0
        assert ResidueGenerator.get(residueGenerator.id) == null
        assert response.redirectedUrl == '/residueGenerator/list'
    }
}
