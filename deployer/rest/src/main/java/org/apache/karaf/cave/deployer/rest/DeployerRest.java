/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.cave.deployer.rest;

import org.apache.karaf.cave.deployer.api.Bundle;
import org.apache.karaf.cave.deployer.api.Deployer;
import org.apache.karaf.cave.deployer.api.Feature;
import org.apache.karaf.cave.deployer.api.FeaturesRepository;

import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

@Path("/")
public class DeployerRest {

    private Deployer deployer;

    @Path("/artifact/explode")
    @Consumes("application/json")
    @POST
    public void explode(KarExplodeRequest request) throws Exception {
        deployer.explode(request.getArtifactUrl(), request.getRepositoryUrl());
    }

    @Path("/artifact/extract")
    @Consumes("application/json")
    @POST
    public void extract(String artifactUrl, String directory) throws Exception {
        deployer.extract(artifactUrl, directory);
    }

    @Path("/artifact/upload")
    @Consumes("application/json")
    @POST
    public void upload(UploadRequest request) throws Exception {
        deployer.upload(request.getGroupId(),
                request.getArtifactId(),
                request.getVersion(),
                request.getArtifactUrl(),
                request.getRepositoryUrl());
    }

    @Path("/artifact/download")
    @Consumes("application/json")
    @POST
    public void download(String artifactUrl, String localPath) throws Exception {
        deployer.download(artifactUrl, localPath);
    }

    @Path("/bundle/deploy")
    @Consumes("application/json")
    @POST
    public void deployBundle(DeployRequest request) throws Exception {
        deployer.deployBundle(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/bundle/undeploy")
    @Consumes("application/json")
    @POST
    public void undeployBundle(DeployRequest request) throws Exception {
        deployer.undeployBundle(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/bundle/start")
    @Consumes("application/json")
    @POST
    public void startBundle(DeployRequest request) throws Exception {
        deployer.startBundle(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/bundle/stop")
    @Consumes("application/json")
    @POST
    public void stopBundle(DeployRequest request) throws Exception {
        deployer.stopBundle(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/bundles")
    @Consumes("application/json")
    @Produces("application/json")
    @GET
    public List<Bundle> listBundles(BasicRequest request) throws Exception {
        return deployer.listBundles(request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/kar/install")
    @Consumes("application/json")
    @POST
    public void installKar(DeployRequest request) throws Exception {
        deployer.installKar(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/kar/uninstall")
    @Consumes("application/json")
    @POST
    public void uninstallKar(DeployRequest request) throws Exception {
        deployer.uninstallKar(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/kars")
    @Consumes("application/json")
    @Produces("application/json")
    @GET
    public List<String> listKars(BasicRequest request) throws Exception {
        return deployer.listKars(request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/feature/assemble")
    @Consumes("application/json")
    @POST
    public void assembleFeature(FeatureAssembleRequest request) throws Exception {
        deployer.assembleFeature(request.getGroupId(),
                request.getArtifactId(),
                request.getVersion(),
                request.getRepositoryUrl(),
                request.getFeature(),
                request.getFeatureRepositories(),
                request.getFeatures(),
                request.getBundles(),
                request.getConfigs());
    }

    @Path("/feature/repository")
    @Consumes("application/json")
    @POST
    public void addFeaturesRepository(DeployRequest request) throws Exception {
        deployer.addFeaturesRepository(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/feature/repository")
    @Consumes("application/json")
    @DELETE
    public void removeFeaturesRepository(DeployRequest request) throws Exception {
        deployer.removeFeaturesRepository(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/feature/repositories")
    @Consumes("application/json")
    @Produces("application/json")
    @GET
    public List<FeaturesRepository> listFeaturesRepositories(BasicRequest request) throws Exception {
        return deployer.listFeaturesRepositories(request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/feature/install")
    @Consumes("application/json")
    @POST
    public void installFeature(DeployRequest request) throws Exception {
        deployer.installFeature(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/feature/uninstall")
    @Consumes("application/json")
    @POST
    public void uninstallFeature(DeployRequest request) throws Exception {
        deployer.uninstallFeature(request.getArtifactUrl(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/features")
    @Consumes("application/json")
    @Produces("application/json")
    @GET
    public List<Feature> listFeatures(BasicRequest request) throws Exception {
        return deployer.listFeatures(request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/config/create")
    @Consumes("application/json")
    @POST
    public void createConfig(ConfigRequest request) throws Exception {
        deployer.createConfig(request.getPid(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/config")
    @Consumes("application/json")
    @DELETE
    public void deleteConfig(ConfigRequest request) throws Exception {
        deployer.deleteConfig(request.getPid(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/config/properties")
    @Consumes("application/json")
    @Produces("application/json")
    @GET
    public Map<String, String> getConfigProperties(ConfigRequest request) throws Exception {
        return deployer.getConfigProperties(request.getPid(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/config/update")
    @Consumes("application/json")
    @POST
    public void updateConfig(ConfigUpdateRequest request) throws Exception {
        deployer.updateConfig(request.getConfig(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/config/property/set")
    @Consumes("application/json")
    @POST
    public void setConfigProperty(ConfigPropertyRequest request) throws Exception {
        deployer.setConfigProperty(request.getPid(),
                request.getKey(),
                request.getValue(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/config/property/get")
    @Consumes("application/json")
    @GET
    public String getConfigProperty(ConfigPropertyKeyRequest request) throws Exception {
        return deployer.getConfigProperty(request.getPid(),
                request.getKey(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/config/property")
    @Consumes("application/json")
    @DELETE
    public void deleteConfigProperty(ConfigPropertyKeyRequest request) throws Exception {
        deployer.deleteConfigProperty(request.getPid(),
                request.getKey(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/config/property/append")
    @Consumes("application/json")
    @POST
    public void appendConfigProperty(ConfigPropertyRequest request) throws Exception {
        deployer.appendConfigProperty(request.getPid(),
                request.getKey(),
                request.getValue(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }
    @Path("/cluster/feature/repository")
    @Consumes("application/json")
    @POST
    public void clusterAddFeaturesRepository(ClusterDeployRequest request) throws Exception {
        deployer.clusterAddFeaturesRepository(request.getArtifactUrl(),
                request.getClusterGroup(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/cluster/feature/repository")
    @Consumes("application/json")
    @DELETE
    public void clusterRemoveFeaturesRepository(ClusterDeployRequest request) throws Exception {
        deployer.clusterRemoveFeaturesRepository(request.getArtifactUrl(),
                request.getClusterGroup(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/cluster/feature/install")
    @Consumes("application/json")
    @POST
    public void clusterInstallFeature(ClusterDeployRequest request) throws Exception {
        deployer.clusterFeatureInstall(request.getArtifactUrl(),
                request.getClusterGroup(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/cluster/feature/uninstall")
    @Consumes("application/json")
    @POST
    public void clusterUninstallFeature(ClusterDeployRequest request) throws Exception {
        deployer.clusterFeatureUninstall(request.getArtifactUrl(),
                request.getClusterGroup(),
                request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/cluster/nodes")
    @Consumes("application/json")
    @Produces("application/json")
    @GET
    public List<String> clusterNodes(DeployRequest request) throws Exception {
        return deployer.clusterNodes(request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    @Path("/cluster/groups")
    @Consumes("application/json")
    @Produces("application/json")
    @GET
    public Map<String, List<String>> clusterGroups(DeployRequest request) throws Exception {
        return deployer.clusterGroups(request.getJmxUrl(),
                request.getKarafName(),
                request.getUser(),
                request.getPassword());
    }

    public void setDeployer(Deployer deployer) {
        this.deployer = deployer;
    }

}