package resourceService;

import resources.TestResource;

public class ResourceService implements ResourceServiceI {
   private TestResource res;

    public ResourceService(TestResource res){
        this.res = res;
    }

    @Override
    public TestResource getResource() {
        return res;
    }

}
