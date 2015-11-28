package HistoricoDeColeta


import org.junit.*
import grails.test.mixin.*

@TestFor(ColetaController)
@Mock(Coleta)
class ColetaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/coleta/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.coletaInstanceList.size() == 0
        assert model.coletaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.coletaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.coletaInstance != null
        assert view == '/coleta/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/coleta/show/1'
        assert controller.flash.message != null
        assert Coleta.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/coleta/list'

        populateValidParams(params)
        def coleta = new Coleta(params)

        assert coleta.save() != null

        params.id = coleta.id

        def model = controller.show()

        assert model.coletaInstance == coleta
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/coleta/list'

        populateValidParams(params)
        def coleta = new Coleta(params)

        assert coleta.save() != null

        params.id = coleta.id

        def model = controller.edit()

        assert model.coletaInstance == coleta
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/coleta/list'

        response.reset()

        populateValidParams(params)
        def coleta = new Coleta(params)

        assert coleta.save() != null

        // test invalid parameters in update
        params.id = coleta.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/coleta/edit"
        assert model.coletaInstance != null

        coleta.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/coleta/show/$coleta.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        coleta.clearErrors()

        populateValidParams(params)
        params.id = coleta.id
        params.version = -1
        controller.update()

        assert view == "/coleta/edit"
        assert model.coletaInstance != null
        assert model.coletaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/coleta/list'

        response.reset()

        populateValidParams(params)
        def coleta = new Coleta(params)

        assert coleta.save() != null
        assert Coleta.count() == 1

        params.id = coleta.id

        controller.delete()

        assert Coleta.count() == 0
        assert Coleta.get(coleta.id) == null
        assert response.redirectedUrl == '/coleta/list'
    }
}
